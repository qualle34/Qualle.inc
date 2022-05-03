CREATE FUNCTION get_last_login_users_count()
    RETURNS INT NOT DETERMINISTIC
BEGIN
    declare temp int;
    SELECT COUNT(DISTINCT u.id) INTO temp FROM user AS u LEFT JOIN session AS s ON u.id = s.user_id WHERE s.created_at IS NOT NULL AND s.created_at > timestamp(NOW() - INTERVAL 30 DAY);
    RETURN temp;
END |

CREATE FUNCTION get_all_purchases_count()
    RETURNS INT NOT DETERMINISTIC
BEGIN
    declare temp int;
    SELECT COUNT(*) INTO temp FROM purchase;
    RETURN temp;
END |

CREATE FUNCTION get_purchases_count_for(productid BIGINT)
    RETURNS INT NOT DETERMINISTIC
BEGIN
    declare temp int;
    SELECT COUNT(*) INTO temp FROM purchase where product_id = productid;
    RETURN temp;
END |

CREATE FUNCTION get_most_popular_product_id()
    RETURNS INT NOT DETERMINISTIC
BEGIN
    declare temp int;
    SELECT COUNT(*) AS count, purchase.product_id INTO temp FROM purchase GROUP BY purchase.product_id ORDER BY count DESC LIMIT 1;
    RETURN temp;
END |
