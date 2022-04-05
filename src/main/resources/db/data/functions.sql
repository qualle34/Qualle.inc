CREATE FUNCTION add_metadata()
    RETURNS BIGINT NOT DETERMINISTIC
BEGIN
    INSERT INTO metadata(created_at, created_by, enabled) VALUES (NOW(), CURRENT_USER(), true);
    RETURN LAST_INSERT_ID();
END |

CREATE PROCEDURE clear_sessions()
BEGIN
    DELETE FROM session;
END |

CREATE PROCEDURE clear_sessions_for(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid;
END |

CREATE PROCEDURE clear_logs(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid;
END |

CREATE PROCEDURE clear_old_logs(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid;
END |