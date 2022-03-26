CREATE FUNCTION add_metadata()
    RETURNS BIGINT NOT DETERMINISTIC
BEGIN
    INSERT INTO metadata(created_at, created_by, enabled) VALUES (NOW(), CURRENT_USER(), true);
    RETURN LAST_INSERT_ID();
END |

CREATE TRIGGER user_metadata_handler
    BEFORE INSERT
    ON user
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER card_metadata_handler
    BEFORE INSERT
    ON card
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER feedback_metadata_handler
    BEFORE INSERT
    ON feedback
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER vacancy_metadata_handler
    BEFORE INSERT
    ON vacancy
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER product_metadata_handler
    BEFORE INSERT
    ON product
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER review_metadata_handler
    BEFORE INSERT
    ON review
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER developer_metadata_handler
    BEFORE INSERT
    ON developer
    FOR EACH ROW
BEGIN
    SET NEW.metadata_id = add_metadata();
END |
