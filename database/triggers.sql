SET GLOBAL log_bin_trust_function_creators = 1;

DROP TRIGGER IF EXISTS qualleinc.user_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.card_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.feedback_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.vacancy_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.product_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.review_metadata_handler;
DROP TRIGGER IF EXISTS qualleinc.developer_metadata_handler;
DROP FUNCTION IF EXISTS add_metadata;

DELIMITER |

CREATE FUNCTION add_metadata()
RETURNS BIGINT NOT DETERMINISTIC BEGIN  
	INSERT INTO qualleinc.metadata(created_at, created_by, enabled) VALUES (NOW(), CURRENT_USER(), true);  
	RETURN LAST_INSERT_ID();  
END |  

CREATE TRIGGER user_metadata_handler BEFORE INSERT ON qualleinc.user
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER card_metadata_handler BEFORE INSERT ON qualleinc.card
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER feedback_metadata_handler BEFORE INSERT ON qualleinc.feedback
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER vacancy_metadata_handler BEFORE INSERT ON qualleinc.vacancy
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER product_metadata_handler BEFORE INSERT ON qualleinc.product
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER review_metadata_handler BEFORE INSERT ON qualleinc.review
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

CREATE TRIGGER developer_metadata_handler BEFORE INSERT ON qualleinc.developer
FOR EACH ROW BEGIN
  SET NEW.metadata_id = add_metadata();
END |

DELIMITER ;