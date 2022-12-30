DROP TABLE IF EXISTS `bbs_tag`;

CREATE TABLE `bbs_tag`
(
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `content`     varchar(1000)        DEFAULT NULL COMMENT '标签内容',
    `click_count` int                  DEFAULT '0' COMMENT '标签简介',
    `sort` int NOT NULL COMMENT '显示顺序',
    `status` tinyint NOT NULL COMMENT '状态（0正常 1停用）',
    `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';