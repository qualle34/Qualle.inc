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