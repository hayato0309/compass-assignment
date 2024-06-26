DROP SCHEMA IF EXISTS compass_assignment;
CREATE SCHEMA compass_assignment;
USE compass_assignment;

DROP TABLE IF EXISTS facilitators_students;

CREATE TABLE facilitators_students
(
  teacher_id INT(10),
  student_id INT(10),
  student_name VARCHAR(40) CHARACTER SET utf8,
  login_id VARCHAR(20) CHARACTER SET utf8,
  class_id INT(10),
  class_name VARCHAR(10) CHARACTER SET utf8
);

INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 1, "佐藤", "foo123", 1, "クラスA");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (2, 2, "鈴木", "bar456", 1, "クラスB");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 3, "田中", "baz789", 1, "クラスC");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 4, "加藤", "hoge0000", 1, "クラスA");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (2, 5, "太田", "huga1234", 1, "クラスB");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 6, "佐々木", "piyo5678", 1, "クラスC");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 7, "小田原", "fizz9999", 1, "クラスA");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (2, 8, "Smith", "buzz777", 1, "クラスB");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 9, "Johnson", "fizzbuss#123", 1, "クラスC");
INSERT INTO facilitators_students (teacher_id, student_id, student_name, login_id, class_id, class_name) VALUES (1, 10, "Williams", "xxx:42", 1, "クラスA");