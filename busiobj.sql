
--------------------------------------------------------
--添加日期:　2018-05-14

-- CREATE TABLE BUSSINESS_DATA (
  ID            serial      PRIMARY KEY NOT NULL,
  ENT_ID        int4                     NOT NULL,
  NAME          varchar(10)              NOT NULL,
  DESCR         varchar(200)                    ,
  CREATE_TIME      TIMESTAMP                  NOT NULL,
  LAST_EDIT_TIME   TIMESTAMP                  NOT NULL,
  Table_ID      int4                     NOT NULL
);

CREATE INDEX i_bd_ent ON BUSSINESS_DATA (ENT_ID,NAME);
COMMENT ON COLUMN BUSSINESS_DATA.ID IS '主键，ID';
COMMENT ON COLUMN BUSSINESS_DATA.ENT_ID IS '企业ID';
COMMENT ON COLUMN BUSSINESS_DATA.NAME IS '名称';
COMMENT ON COLUMN BUSSINESS_DATA.DESCR IS '描述';
COMMENT ON COLUMN BUSSINESS_DATA.CREATE_TIME IS '创建时间';
COMMENT ON COLUMN BUSSINESS_DATA.LAST_EDIT_TIME IS '最后修改时间';
COMMENT ON COLUMN BUSSINESS_DATA.Table_ID IS '实体表id';
--责任人：cyx
--说明：业务数据表(BUSSINESS_DATA)
--------------------------------------------------------


--------------------------------------------------------
--添加日期:　2018-05-14
--责任人：cyx
--说明：创建业务数据表(BUSSINESS_DATA)回退sql
--------------------------------------------------------
DROP TABLE BUSSINESS_DATA;