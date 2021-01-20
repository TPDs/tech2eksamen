INSERT INTO supervisor (name, email) VALUES
    ('Teacher1','t1@kea.dk'),
    ('Teacher2','t2@kea.dk'),
    ('Teacher3','t3@kea.dk'),
    ('Teacher4','t4@kea.dk');

INSERT INTO student (name, email,supervisor_id) VALUES
('michael','mich95k9@stud.kea.dk',2),
('Morten','mor998@stud.kea.dk',1),
('Ida','id23@stud.kea.dk',3),
('Hans','mih99@stud.kea.dk',2),
('Braian','m398@stud.kea.dk',1),
('Ulla','ida223@stud.kea.dk',3);

--INSERT INTO student (name, email) VALUES
--('michael','mich95k9@stud.kea.dk'),
--('Morten','mor998@stud.kea.dk'),
--('Ida','ida223@stud.kea.dk');

--INSERT INTO student_class(student_id,supervisor_id) values (2,2), (3,2),(1,1);