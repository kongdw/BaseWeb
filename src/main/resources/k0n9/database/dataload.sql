INSERT INTO SYS_USER (ID, USERNAME, EMAIL, PHONE_NUMBER, PASSWORD, SALT, CREATE_DATE, STATUS, DELETED, IS_ADMIN) VALUES (1, 'admin', 'kong.dw@hotmail.com', '13693601808', 'b9d11b3be25f5a1a7dc8ca04cd310b28', 'admin', '2015-11-16 16:06:17.320000000', 'normal', FALSE , true);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (1,'所有','*','所有数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (2,'新增','create','新增数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (3,'修改','update','修改数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (4,'删除','delete','删除数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (5,'查看','view','查看数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (6,'审核','audit','审核数据操作的权限',1);
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (1,'资源','','',0,'0/','',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (2,'档案管理','archive','',1,'0/1/','menu-icon fa fa-desktop',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (3,'档案浏览','browse','/archive/browse',2,'0/1/2/','',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (4,'我的借阅','borrow','/archive/borrow',2,'0/1/2/','',1,FALSE);
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (5,'借阅历史','history','/archive/history',2,'0/1/2/','',1,FALSE);
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (6,'借阅审核','audit','/archive/audit',2,'0/1/2/','',1,FALSE);

INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (7,'系统管理','sys','',1,'0/1/','menu-icon fa fa-cogs',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (8,'用户管理','user','/sys/user',7,'0/1/','ace-icon fa fa-users',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (9,'权限管理','permission','/sys/permission',7,'0/1/','',1,TRUE );
INSERT INTO SYS_RESOURCE (ID, NAME, IDENTITY, URL, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (10,'数据字典','dict','/sys/dict',7,'0/1/','',1,TRUE );

INSERT INTO ams_type (id, name, weight, is_show) VALUES ('1', '收文', '3', '1');
INSERT INTO ams_type (id, name, weight, is_show) VALUES ('2', '发文', '2', '1');
INSERT INTO ams_type (id, name, weight, is_show) VALUES ('3', '归档', '1', '1');

INSERT INTO ams_category (id, name, weight, is_show) VALUES ('1', '财会类', '0', '1');
INSERT INTO ams_category (id, name, weight, is_show) VALUES ('2', '党群类', '0', '1');
INSERT INTO ams_category (id, name, weight, is_show) VALUES ('3', '教学类', '0', '1');
INSERT INTO ams_category (id, name, weight, is_show) VALUES ('4', '经营类', '0', '1');
INSERT INTO ams_category (id, name, weight, is_show) VALUES ('5', '行政类', '0', '1');

INSERT INTO ams_deadline (id, name, weight, is_show) VALUES ('1', '长期', '0', '1');
INSERT INTO ams_deadline (id, name, weight, is_show) VALUES ('2', '短期', '0', '1');
INSERT INTO ams_deadline (id, name, weight, is_show) VALUES ('3', '永久', '0', '1');
INSERT INTO ams_deadline (id, name, weight, is_show) VALUES ('4', '中期', '0', '1');


INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('1', '报告', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('2', '公告', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('3', '函', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('4', '会议纪要', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('5', '决定', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('6', '命令', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('7', '批复', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('8', '请示', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('9', '其它', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('10', '通报', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('11', '通告', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('12', '通知', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('13', '议案', '0', '1');
INSERT INTO ams_doc_class (id, name, weight, is_show) VALUES ('14', '意见', '0', '1');

INSERT INTO ams_privacy_level (id, name, weight, is_show) VALUES ('1', '机密', '0', '1');
INSERT INTO ams_privacy_level (id, name, weight, is_show) VALUES ('2', '绝密', '0', '1');
INSERT INTO ams_privacy_level (id, name, weight, is_show) VALUES ('3', '普通', '0', '1');
INSERT INTO ams_privacy_level (id, name, weight, is_show) VALUES ('4', '一般', '0', '1');

INSERT INTO ams_urgent_level (id, name, weight, is_show) VALUES ('1', '急件', '0', '1');
INSERT INTO ams_urgent_level (id, name, weight, is_show) VALUES ('2', '特急', '0', '1');
INSERT INTO ams_urgent_level (id, name, weight, is_show) VALUES ('3', '一般', '0', '1');

INSERT INTO ams_archive (id, title, type_id, category_id, deadline_id, doc_class_id, year, doc_no, doc_date, forcer_no, box_no, fonds_no, part_num, page_num, responsible, privacy_level_id, urgent_level_id, remark) VALUES ('1', '建设四个现代化', '1', '1', '1', '1', '2015', 'DA-0001', '2015-01-01', '1', '1', '1', '1', '1', '李光', '1', '1', '请勿删除');

