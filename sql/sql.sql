create database online_exam_system;
use online_exam_system;

create table student
(
    s_id       char(8)        not null primary key,
    s_name     char(12)       null,
    s_password char(16)       null,
    s_grade    int            null,
    s_major    char(32)       null,
    s_class    int            null,
    s_sex      enum ('0','1') null,
    s_college  char(16)       null,
    constraint Student_s_id_uindex
        unique (s_id)
)
    comment '学生表';


create table teacher
(
    t_id       char(8)        not null primary key,
    t_name     char(12)       null,
    t_password char(16)       null,
    t_phone    char(12)       null,
    t_role     enum ('0','1') null,
    if_delete  enum ('0','1') null,
    constraint teacher_t_id_uindex
        unique (t_id)
);

create table title
(
    te_id      char(12)               not null primary key,
    t_id       char(8)                null,
    te_content char(255)              null,
    te_picture char(64)               null,
    te_type    enum ('0','1','2','3') null,
    te_answer  char(128)              null,
    te_score   int                    null,
    if_delete  enum ('0','1')         null,
    constraint title_te_id_uindex
        unique (te_id),
    constraint title_teacher_t_id_fk
        foreign key (t_id) references teacher (t_id)
            on update cascade on delete cascade
)
    comment '试题表';


create table exam
(
    e_id      char(16) not null primary key,
    t_id      char(8)  null,
    e_subject char(32) null,
    e_begin   datetime null,
    `e-end`   datetime null,
    constraint exam_e_id_uindex
        unique (e_id),
    constraint exam_teacher_t_id_fk
        foreign key (t_id) references teacher (t_id)
            on update cascade on delete cascade
)
    comment '试卷表';

create table exam_title
(
    e_id  char(6)  not null,
    te_id char(12) not null,
    primary key (e_id, te_id),
    foreign key (e_id) references exam (e_id)
        on update cascade on delete cascade,
    foreign key (te_id) references title (te_id)
        on update cascade on delete cascade
);

create table student_exam
(
    se_id         char(12) not null primary key,
    s_id          char(8)  null,
    e_id          char(6)  null,
    choice_score  int      null,
    correct_score int      null,
    constraint student_exam_se_id_uindex
        unique (se_id),
    constraint student_exam_exam_e_id_fk
        foreign key (e_id) references exam (e_id)
            on update cascade on delete cascade,
    constraint student_exam_student_s_id_fk
        foreign key (s_id) references student (s_id)
            on update cascade on delete cascade
);


create table student_exam_detail
(
    se_id      char(12)  not null,
    te_id      char(12)  not null,
    sed_answer char(128) null,
    sed_score  int       null,
    t_id       char(8)   null,
    primary key (se_id, te_id),
    constraint student_exam_detail_student_exam_se_id_fk
        foreign key (se_id) references student_exam (se_id)
            on update cascade on delete cascade,
    constraint student_exam_detail_teacher_t_id_fk
        foreign key (t_id) references teacher (t_id)
            on update cascade on delete cascade,
    constraint student_exam_detail_title_te_id_fk
        foreign key (te_id) references title (te_id)
            on update cascade on delete cascade
)
    comment '学生考试细则表';

create table score_appeal
(
    s_id            char(8)        not null,
    te_id           char(12)       not null,
    sa_content      char(128)      null,
    sa_result       enum ('0','1') null,
    sa_back_content char(128)      null,
    primary key (s_id, te_id),
    constraint score_appeal_student_exam_detail_t_id_fk
        foreign key (te_id) references student_exam_detail (t_id)
            on update cascade on delete cascade,
    constraint score_appeal_student_exam_s_id_fk
        foreign key (s_id) references student_exam (s_id)
            on update cascade on delete cascade
);