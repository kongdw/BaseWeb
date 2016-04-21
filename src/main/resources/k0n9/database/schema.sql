DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_resource;
DROP TABLE IF EXISTS sys_role_resource_permission;
DROP TABLE IF EXISTS sys_permission;
DROP TABLE IF EXISTS sys_organization;
DROP TABLE IF EXISTS sys_user_role;
DROP TABLE IF EXISTS sys_user_organization;

DROP TABLE IF EXISTS ams_archive_file;
DROP TABLE IF EXISTS ams_archive;

DROP TABLE IF EXISTS ams_privacy_level;
DROP TABLE IF EXISTS ams_urgent_level;
DROP TABLE IF EXISTS ams_type;
DROP TABLE IF EXISTS ams_category;
DROP TABLE IF EXISTS ams_deadline;
DROP TABLE IF EXISTS ams_doc_class;
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
CREATE TABLE sys_user (
  id           BIGINT   NOT NULL AUTO_INCREMENT,
  username     VARCHAR(100) DEFAULT NULL,
  email        VARCHAR(100) DEFAULT NULL,
  phone_number VARCHAR(20)  DEFAULT NULL,
  password     VARCHAR(100) DEFAULT NULL,
  salt         VARCHAR(10)  DEFAULT NULL,
  create_date  DATETIME NOT NULL,
  status       VARCHAR(50)  DEFAULT NULL,
  deleted      BOOLEAN      DEFAULT NULL,
  is_admin     BOOLEAN      DEFAULT NULL,
  CONSTRAINT PK_SYS_USER PRIMARY KEY (id)
);
CREATE UNIQUE INDEX uidx_sys_user_username ON sys_user (username);
CREATE UNIQUE INDEX uidx_sys_user_email ON sys_user (email);
CREATE UNIQUE INDEX uidx_sys_user_phone_number ON sys_user (phone_number);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   角色
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
CREATE TABLE sys_role (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(100) DEFAULT NULL,
  role        VARCHAR(100) DEFAULT NULL,
  description VARCHAR(200) DEFAULT NULL,
  is_show     BOOLEAN      DEFAULT NULL,
  CONSTRAINT pk_sys_role PRIMARY KEY (id)
);
CREATE UNIQUE INDEX idx_sys_role_name ON sys_role (name);
CREATE UNIQUE INDEX idx_sys_role_role ON sys_role (role);
CREATE INDEX idx_sys_role_show ON sys_role (is_show);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   资源
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
CREATE TABLE sys_role_resource_permission (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  role_id        BIGINT       DEFAULT NULL,
  resource_id    BIGINT       DEFAULT NULL,
  permission_ids VARCHAR(500) DEFAULT NULL,
  CONSTRAINT pk_sys_role_resource_permission PRIMARY KEY (id)
);
CREATE UNIQUE INDEX uidx_sys_role_resource_permission ON sys_role_resource_permission (role_id, resource_id);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   权限字典
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE sys_permission (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(100) DEFAULT NULL,
  permission  VARCHAR(100) DEFAULT NULL,
  description VARCHAR(200) DEFAULT NULL,
  is_show     BOOLEAN      DEFAULT NULL,
  CONSTRAINT pk_sys_permission PRIMARY KEY (id)
);
CREATE INDEX idx_sys_permission_name ON sys_permission (name);
CREATE INDEX idx_sys_permission_permission ON sys_permission (permission);
CREATE INDEX idx_sys_permission_show ON sys_permission (is_show);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   组织机构
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE sys_organization (
  id         BIGINT NOT NULL AUTO_INCREMENT,
  name       VARCHAR(100) DEFAULT NULL,
  type       VARCHAR(20)  DEFAULT NULL,
  parent_id  BIGINT       DEFAULT NULL,
  parent_ids VARCHAR(200) DEFAULT '',
  icon       VARCHAR(200) DEFAULT NULL,
  weight     INT(11)      DEFAULT NULL,
  is_show    BOOLEAN      DEFAULT NULL,
  CONSTRAINT pk_sys_organization PRIMARY KEY (id)
);
CREATE INDEX idx_sys_organization_name ON sys_organization (name);
CREATE INDEX idx_sys_organization_type ON sys_organization (type);
CREATE INDEX idx_sys_organization_parent_id ON sys_organization (parent_id);
CREATE INDEX idx_sys_organization_parent_ids_weight ON sys_organization (parent_ids, weight);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户对应角色
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE sys_user_role (
  id      BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT pk_sys_user_role PRIMARY KEY (id)
);
CREATE UNIQUE INDEX uidx_sys_user_role ON sys_user_role (user_id, role_id);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   用户对应组织机构
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE sys_user_organization (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  user_id         BIGINT NOT NULL,

  organization_id BIGINT NOT NULL,
  CONSTRAINT pk_sys_user_organization PRIMARY KEY (id)
);
CREATE UNIQUE INDEX uidx_sys_user_organization ON sys_user_organization (user_id, organization_id);
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--                   档案
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

CREATE TABLE ams_urgent_level (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_urgent_level PRIMARY KEY (id)
);


CREATE TABLE ams_privacy_level (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_privacy_level PRIMARY KEY (id)
);

CREATE TABLE ams_type (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_type PRIMARY KEY (id)
);

CREATE TABLE ams_category (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_category PRIMARY KEY (id)
);

CREATE TABLE ams_deadline (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_deadline PRIMARY KEY (id)
);

CREATE TABLE ams_doc_class (
  id      BIGINT      NOT NULL AUTO_INCREMENT,
  name    VARCHAR(50) NOT NULL,
  weight  INT         NOT NULL  DEFAULT 0,
  is_show BOOLEAN               DEFAULT NULL,
  CONSTRAINT pk_ams_doc_class PRIMARY KEY (id)
);
CREATE TABLE ams_archive (
  id               BIGINT       NOT NULL AUTO_INCREMENT,
  title            VARCHAR(500) NOT NULL,
  type_id          BIGINT       NOT NULL,
  category_id      BIGINT       NOT NULL,
  deadline_id      BIGINT       NOT NULL,
  doc_class_id     BIGINT       DEFAULT NULL,
  year             INT(4)       NOT NULL,
  doc_no           VARCHAR(255) NOT NULL,
  doc_date         DATETIME     NOT NULL,
  forcer_no        VARCHAR(20)  DEFAULT NULL,
  box_no           VARCHAR(20)  DEFAULT NULL,
  fonds_no         VARCHAR(255) DEFAULT NULL,
  part_num         INT(11)      DEFAULT NULL,
  page_num         INT(11)      DEFAULT NULL,
  responsible      VARCHAR(20)  DEFAULT NULL,
  dept             VARCHAR(20)  DEFAULT NULL,
  privacy_level_id BIGINT       DEFAULT NULL,
  urgent_level_id  BIGINT       DEFAULT NULL,
  remark           VARCHAR(255) DEFAULT NULL,
  CONSTRAINT pk_ams_archive PRIMARY KEY (id),
  CONSTRAINT FK_AMS_category FOREIGN KEY (category_id) REFERENCES ams_category (id),
  CONSTRAINT FK_AMS_deadline FOREIGN KEY (deadline_id) REFERENCES ams_deadline (id),
  CONSTRAINT FK_AMS_doc_class FOREIGN KEY (doc_class_id) REFERENCES ams_doc_class (id),
  CONSTRAINT FK_AMS_privacy_level FOREIGN KEY (privacy_level_id) REFERENCES ams_privacy_level (id),
  CONSTRAINT FK_AMS_urgent_level FOREIGN KEY (urgent_level_id) REFERENCES ams_urgent_level (id)
);

CREATE TABLE ams_archive_file (
  id          BIGINT   NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255) DEFAULT NULL,
  path        VARCHAR(255) DEFAULT NULL,
  size        DOUBLE       DEFAULT NULL,
  type        VARCHAR(255) DEFAULT NULL,
  archive_id  BIGINT       DEFAULT NULL,
  upload_date DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_AMS_ARCHIVE FOREIGN KEY (archive_id) REFERENCES ams_archive (id)
);
