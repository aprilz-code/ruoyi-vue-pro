DROP TABLE IF EXISTS `bbs_tag`;

CREATE TABLE `bbs_tag`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `content`     varchar(1000)        DEFAULT NULL COMMENT '标签内容',
    `click_count` int                  DEFAULT '0' COMMENT '标签点击数',
    `sort` int NOT NULL COMMENT '显示顺序',
    `status` tinyint NOT NULL COMMENT '状态（0正常 1停用）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

DROP TABLE IF EXISTS `bbs_classify`;

CREATE TABLE `bbs_classify`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `classify_name`     varchar(64)        NOT NULL COMMENT '分类名',
    `description` varchar(256)      DEFAULT NULL COMMENT '标签简介',
    `click_count` int                  DEFAULT '0' COMMENT '分类点击数',
    `sort` int NOT NULL COMMENT '显示顺序',
    `status` tinyint NOT NULL COMMENT '状态（0正常 1停用）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='分类表';


DROP TABLE IF EXISTS `bbs_article`;

CREATE TABLE `bbs_article`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`         varchar(200)         DEFAULT NULL COMMENT '文章标题',
    `thumb`      varchar(255)         DEFAULT NULL COMMENT '标题缩略图地址',
    `summary`       varchar(200)         DEFAULT NULL COMMENT '文章简介',
    `content`       longtext COMMENT '文章内容',
    `tag_ids`       varchar(255)         DEFAULT NULL COMMENT '标签ids',
    `click_count`   int                  DEFAULT 0 COMMENT '文章点击数',
    `collect_count` int                  DEFAULT 0 COMMENT '文章收藏数',
    `share_count` int                  DEFAULT 0 COMMENT '文章分享数',
    `is_original`   tinyint(1)           DEFAULT 1 COMMENT '是否原创（0:不是 1：是）',
    `author`        varchar(255)         DEFAULT NULL COMMENT '作者',
    `articles_part` varchar(255)         DEFAULT NULL COMMENT '文章出处',
    `classify_id` varchar(32)          DEFAULT NULL COMMENT '文章分类UID',
    `is_top` tinyint NOT NULL default 0 COMMENT '是否置顶（0不是 1是）',
    `level`         tinyint(1) DEFAULT 0 COMMENT '推荐等级(0-5)',
    `open_comment`  tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否开启评论(0:否 1:是)',
    `type`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型【0 文章， 1：推广】',
    `outside_link` varchar(1024) DEFAULT NULL COMMENT '外链【如果是推广，那么将跳转到外链】',
    `status` tinyint NOT NULL default 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='文章表';



DROP TABLE IF EXISTS `bbs_mi_log`;
CREATE TABLE `bbs_mi_log`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `min_step`    int         NOT NULL COMMENT '最小步数',
    `max_step`    int         NOT NULL COMMENT '最大步数',
    `real_step`   int         NOT NULL COMMENT '实际步数',
    `mobile`      VARCHAR(64)          DEFAULT NULL COMMENT '手机号码',
    `pwd`         VARCHAR(64)          DEFAULT NULL COMMENT '密码',
    `source`      VARCHAR(64)          DEFAULT NULL COMMENT '来源 h5 xxl',
    `status` tinyint NOT NULL default 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='米日志表';


DROP TABLE IF EXISTS `bbs_mi_job`;
CREATE TABLE `bbs_mi_job`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `mobile`      VARCHAR(64)          DEFAULT NULL COMMENT '手机号码',
    `pwd`         VARCHAR(64)          DEFAULT NULL COMMENT '密码',
    `card_no`     VARCHAR(64)          DEFAULT NULL COMMENT '卡密',
    `cron`        VARCHAR(64)          DEFAULT NULL COMMENT '执行计划',
    `min_step`    int         NOT NULL COMMENT '最小步数',
    `max_step`    int         NOT NULL COMMENT '最大步数',
    `end_time`    timestamp   NOT NULL COMMENT '结束时间',
    `job_id`      int         NOT NULL COMMENT 'xxljobId',
    `user_id`     int                  DEFAULT NULL COMMENT '用户id',
    `status` tinyint NOT NULL default 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='米job表';



DROP TABLE IF EXISTS `bbs_mi_card`;
CREATE TABLE `bbs_mi_card`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `card_no`     VARCHAR(64)          DEFAULT NULL COMMENT '卡密',
    `type`        tinyint unsigned NOT NULL DEFAULT '1' COMMENT '1.7day 2.1年 3.永久',
    `status` tinyint NOT NULL default 0 COMMENT '状态',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='米卡密表';


-- chat
DROP TABLE IF EXISTS `bbs_group_msg_content`;
CREATE TABLE `bbs_group_msg_content`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息内容编号',
    `group_id`  bigint NOT NULL COMMENT '群聊id',
    `from_id` int(11) DEFAULT NULL COMMENT '发送者的编号',
    `from_name` varchar(20) DEFAULT NULL COMMENT '发送者的昵称',
    `from_profile` varchar(255) DEFAULT NULL COMMENT '发送者的头像',
    `content` text COMMENT '消息内容',
    `message_type`varchar(32) DEFAULT NULL COMMENT '消息类型编码',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='群聊消息内容表';


DROP TABLE IF EXISTS `bbs_msg_content`;
CREATE TABLE `bbs_msg_content`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息内容编号',
    `private_chat_id`  varchar(64) NOT NULL COMMENT '私聊id,以用户小的id拼上-用户大的id',
    `from_id` int(11) DEFAULT NULL COMMENT '发送者的编号',
    `from_name` varchar(20) DEFAULT NULL COMMENT '发送者的昵称',
    `from_profile` varchar(255) DEFAULT NULL COMMENT '发送者的头像',
    `content` text COMMENT '消息内容',
    `message_type`varchar(32) DEFAULT NULL COMMENT '消息类型编码',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='私聊消息内容表';


DROP TABLE IF EXISTS `bbs_message_type`;
CREATE TABLE `bbs_message_type`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '消息内容编号',
    `type_code` varchar(32) DEFAULT NULL COMMENT '消息类型编码',
    `type_name` varchar(32) DEFAULT NULL COMMENT '消息类型名称',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT='消息类型表';

INSERT INTO `bbs_message_type` (`id`, `type_code`, `type_name`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, 'text', '文本', '', '2023-03-23 09:13:06', '', '2023-03-23 09:13:06', b'0');
INSERT INTO `bbs_message_type` (`id`, `type_code`, `type_name`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2, 'img', '图片', '', '2023-03-23 09:13:18', '', '2023-03-23 09:13:18', b'0');
INSERT INTO `bbs_message_type` (`id`, `type_code`, `type_name`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (3, 'file', '文件', '', '2023-03-23 09:13:28', '', '2023-03-23 09:13:28', b'0');
