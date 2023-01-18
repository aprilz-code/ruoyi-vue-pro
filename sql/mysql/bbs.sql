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

