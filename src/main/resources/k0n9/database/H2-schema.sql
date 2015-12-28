-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id           BIGINT    NOT NULL AUTO_INCREMENT,
  username     VARCHAR(100)       DEFAULT NULL,
  email        VARCHAR(100)       DEFAULT NULL,
  phone_number VARCHAR(20)        DEFAULT NULL,
  password     VARCHAR(100)       DEFAULT NULL,
  salt         VARCHAR(10)        DEFAULT NULL,
  create_date  TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
  status       VARCHAR(50)        DEFAULT NULL,
  deleted      BOOLEAN            DEFAULT NULL,
  is_admin     BOOLEAN            DEFAULT NULL,
  CONSTRAINT PK_SYS_USER PRIMARY KEY (id)
);
CREATE UNIQUE INDEX UIDX_sys_user_username ON sys_user (username);
CREATE UNIQUE INDEX UIDX_sys_user_email ON sys_user (email);
CREATE UNIQUE INDEX UIDX_sys_user_phone_number ON sys_user (phone_number);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   角色
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(100) DEFAULT NULL,
  role        VARCHAR(100) DEFAULT NULL,
  description VARCHAR(200) DEFAULT NULL,
  is_show     BOOLEAN      DEFAULT NULL,
  CONSTRAINT pk_sys_role PRIMARY KEY (id),
);
CREATE UNIQUE INDEX idx_sys_role_name ON sys_role (name);
CREATE UNIQUE INDEX idx_sys_role_role ON sys_role (role);
CREATE INDEX idx_sys_role_show ON sys_role (is_show);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   资源
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_resource;
CREATE TABLE sys_resource (
  id         BIGINT NOT NULL AUTO_INCREMENT,
  name       VARCHAR(100) DEFAULT NULL,
  identity   VARCHAR(100) DEFAULT NULL,
  url        VARCHAR(200) DEFAULT NULL,
  parent_id  BIGINT       DEFAULT NULL,
  parent_ids VARCHAR(200) DEFAULT '',
  icon       VARCHAR(200) DEFAULT NULL,
  weight     INT(11)      DEFAULT NULL,
  is_show    BOOLEAN      DEFAULT NULL,
  CONSTRAINT pk_sys_resource PRIMARY KEY (id)
);
CREATE INDEX idx_sys_resource_name ON sys_resource (name);
CREATE INDEX idx_sys_resource_identity ON sys_resource (identity);
CREATE INDEX idx_sys_resource_user ON sys_resource (url);
CREATE INDEX idx_sys_resource_parent_id ON sys_resource (parent_id);
CREATE INDEX idx_sys_resource_parent_ids_weight ON sys_resource (parent_ids, weight);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   角色对应资源权限
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_role_resource_permission;
CREATE TABLE sys_role_resource_permission (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  role_id        BIGINT       DEFAULT NULL,
  resource_id    BIGINT       DEFAULT NULL,
  permission_ids VARCHAR(500) DEFAULT NULL,
  CONSTRAINT pk_sys_role_resource_permission PRIMARY KEY (id)
);
CREATE UNIQUE INDEX UIDX_sys_role_resource_permission on sys_role_resource_permission (role_id,resource_id);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   权限字典
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
CREATE TABLE sys_permission (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  permission varchar(100) DEFAULT NULL,
  description varchar(200) DEFAULT NULL,
  is_show BOOLEAN DEFAULT NULL,
  CONSTRAINT pk_sys_permission PRIMARY KEY (id)
);
CREATE INDEX idx_sys_permission_name on sys_permission(name);
CREATE INDEX idx_sys_permission_permission on sys_permission (permission);
CREATE INDEX idx_sys_permission_show on sys_permission (is_show);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   组织机构
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_organization;
CREATE TABLE sys_organization (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(100) DEFAULT NULL,
  type varchar(20) DEFAULT NULL,
  parent_id bigint DEFAULT NULL,
  parent_ids varchar(200) DEFAULT '',
  icon varchar(200) DEFAULT NULL,
  weight int(11) DEFAULT NULL,
  is_show BOOLEAN DEFAULT NULL,
  CONSTRAINT pk_sys_organization PRIMARY KEY (id)
);
CREATE INDEX idx_sys_organization_name on sys_organization (name);
CREATE INDEX idx_sys_organization_type on sys_organization (type);
CREATE INDEX idx_sys_organization_parent_id on sys_organization (parent_id);
CREATE INDEX idx_sys_organization_parent_ids_weight on sys_organization (parent_ids,weight);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户对应角色
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role(
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT pk_sys_user_role PRIMARY KEY (id)
);
create UNIQUE INDEX uidx_sys_user_role on sys_user_role(user_id, role_id);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户对应组织机构
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
DROP TABLE IF EXISTS SYS_USER_ORGANIZATION;
CREATE TABLE sys_user_organization(
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL ,
  organization_id BIGINT NOT NULL,
  CONSTRAINT pk_sys_user_organization PRIMARY KEY (id)
);
create UNIQUE INDEX uidx_sys_user_organization on sys_user_organization(user_id, organization_id);
