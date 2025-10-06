INSERT INTO college_authorities (id, authority)
VALUES
    (1, 'READ_USER'),
    (2, 'CREATE_USER'),
    (3, 'UPDATE_USER'),
    (4, 'DELETE_USER');

INSERT INTO college_roles (id, role, authorities)
VALUES
    (1, 'ADMIN', ARRAY[1, 2, 3, 4]),
    (2, 'USER', ARRAY[1]);

INSERT INTO college_users (
     id
    ,external_id
    ,name
    ,email
    ,password
) VALUES (
     1
    ,'d68f83a7-c3a5-4446-9f2e-e1838496f8d2'
    ,'Administrator'
    ,'admin@email.com'
    ,'$2a$12$ENOgBke3fWmsCqVi/KB4tedfDBWFuJW3IgR5D437Saf3WPsy7zwyC' -- password: abc123
);

INSERT INTO college_user_roles (user_id, role_id)
VALUES
    (1, 1);