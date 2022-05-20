USE HFT_ADMINDB;
GO
-- IF EXISTS(SELECT NAME FROM SYS.TABLES WHERE NAME='FUN_SENSITIVE_WORDS_TYPE')
-- DROP TABLE FUN_SENSITIVE_WORDS_TYPE
--    GO
CREATE TABLE FUN_SENSITIVE_WORDS_TYPE
(ID  INT IDENTITY(1,1) NOT NULL primary key,
 CREATE_BY VARCHAR(128),
 UPDATE_BY VARCHAR(128),
 CREATE_DATE DATETIME NOT NULL,
 UPDATE_DATE DATETIME NOT NULL,
 SW_TYPE INT NOT NULL,
 SW_DESC VARCHAR(128)
)
    GO

--  添加表注释
execute sp_addextendedproperty
'MS_Description','敏感词类型表',
'SCHEMA',
'dbo',
'table',
'FUN_SENSITIVE_WORDS_TYPE',
null,
null;

-- 字段注释
EXEC sp_addextendedproperty
'MS_Description', N'ID',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'ID'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建人',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'CREATE_BY'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建时间',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'CREATE_DATE'
GO

EXEC sp_addextendedproperty
'MS_Description', N'修改人',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'UPDATE_BY'
GO

EXEC sp_addextendedproperty
'MS_Description', N'修改时间',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'UPDATE_DATE'
GO


EXEC sp_addextendedproperty
'MS_Description', N'敏感词类型',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'SW_TYPE'
GO

EXEC sp_addextendedproperty
'MS_Description', N'敏感词类型描述',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_TYPE',
'COLUMN', N'SW_DESC'
GO








USE HFT_ADMINDB;
GO
-- IF EXISTS(SELECT NAME FROM SYS.TABLES WHERE NAME='FUN_SENSITIVE_WORDS_VALUE')
-- DROP TABLE FUN_SENSITIVE_WORDS_VALUE
--    GO
CREATE TABLE FUN_SENSITIVE_WORDS_VALUE
(ID  INT IDENTITY(1,1) NOT NULL primary key,
 CREATE_BY VARCHAR(128),
 UPDATE_BY VARCHAR(128),
 CREATE_DATE DATETIME NOT NULL,
 UPDATE_DATE DATETIME NOT NULL,
 SW_TYPE INT NOT NULL,
 SW_VALUE VARCHAR(128),
 SW_DESC VARCHAR(128)
)
    GO

--  添加表注释
execute sp_addextendedproperty
'MS_Description','敏感词明细表',
'SCHEMA',
'dbo',
'table',
'FUN_SENSITIVE_WORDS_VALUE',
null,
null;

-- 字段注释
EXEC sp_addextendedproperty
'MS_Description', N'ID',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'ID'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建人',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'CREATE_BY'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建时间',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'CREATE_DATE'
GO

EXEC sp_addextendedproperty
'MS_Description', N'修改人',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'UPDATE_BY'
GO

EXEC sp_addextendedproperty
'MS_Description', N'修改时间',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'UPDATE_DATE'
GO


EXEC sp_addextendedproperty
'MS_Description', N'敏感词类型',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'SW_TYPE'
GO

EXEC sp_addextendedproperty
'MS_Description', N'敏感词描述',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'SW_VALUE'
GO

EXEC sp_addextendedproperty
'MS_Description', N'敏感词额外描述',
'SCHEMA', N'dbo',
'TABLE', N'FUN_SENSITIVE_WORDS_VALUE',
'COLUMN', N'SW_DESC'
GO




INSERT INTO [FUN_SENSITIVE_WORDS_TYPE] VALUES ('1', '1', GETDATE(), GETDATE(), 1, '政治广告色情敏感词库');
GO
INSERT INTO [FUN_SENSITIVE_WORDS_TYPE] VALUES ('1', '1', GETDATE(), GETDATE(), 2, '广告词库');
GO
INSERT INTO [FUN_SENSITIVE_WORDS_TYPE] VALUES ('1', '1', GETDATE(), GETDATE(), 3, '其他词库');
GO


