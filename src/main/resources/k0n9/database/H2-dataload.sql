INSERT INTO SYS_USER (ID, USERNAME, EMAIL, PHONE_NUMBER, PASSWORD, SALT, CREATE_DATE, STATUS, DELETED, IS_ADMIN) VALUES (1, 'David Kong', 'kong.dw@hotmail.com', '13693601808', '123456', '111111', '2015-11-16 16:06:17.320000000', 'normal', FALSE , true);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (1,'所有','*','所有数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (2,'新增','create','新增数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (3,'修改','update','修改数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (4,'删除','delete','删除数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (5,'查看','view','查看数据操作的权限',1);
INSERT INTO sys_permission (id,name,permission,description,is_show) VALUES (6,'审核','audit','审核数据操作的权限',1);
