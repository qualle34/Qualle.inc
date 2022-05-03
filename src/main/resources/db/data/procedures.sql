CREATE PROCEDURE clear_sessions()
BEGIN
    DELETE FROM session;
END |

CREATE PROCEDURE clear_old_sessions(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid AND session.created_at < UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 30 DAY));
END |

CREATE PROCEDURE clear_sessions_for(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid;
END |

CREATE PROCEDURE clear_old_sessions_for(userid BIGINT)
BEGIN
    DELETE FROM session WHERE session.user_id = userid AND session.created_at < UNIX_TIMESTAMP(DATE_SUB(NOW(), INTERVAL 30 DAY));
END |