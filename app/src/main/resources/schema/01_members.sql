DROP TABLE IF EXISTS members;
CREATE TABLE IF NOT EXISTS members(
    id INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY, --ID 自動採番
    member_name TEXT NOT NULL, --氏名
    sex CHARACTER(1) NOT NULL, --性別（0:男性 / 1:女性）
    employee_number CHARACTER VARYING(6), --社員番号
    bumon_name TEXT, --配属先
    vending_machine CHARACTER(1) NOT NULL --おごり自販機使用回数
);