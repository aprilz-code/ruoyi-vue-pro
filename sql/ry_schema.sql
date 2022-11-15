DROP
DATABASE IF EXISTS `ruoyi-vue-pro`;
DROP
USER IF EXISTS 'ry'@'%';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
CREATE
DATABASE `ruoyi-vue-pro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE
`ruoyi-vue-pro`;
CREATE
USER 'ry'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON `ruoyi-vue-pro`.* TO
'ry'@'%';
FLUSH
PRIVILEGES;
