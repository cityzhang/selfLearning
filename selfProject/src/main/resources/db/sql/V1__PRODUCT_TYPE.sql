-- --------------------------------------------------
-- Create user, grant privileges and create database
-- --------------------------------------------------
-- CREATE USER 'aems_performance'@'%' IDENTIFIED BY 'casacasa';


-- ----------------------------
-- Table structure for performance_item
-- ----------------------------
-- 商品分类表
DROP TABLE IF EXISTS `pms_product_category`;
create table pms_product_category
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '上级分类的编号：0表示一级分类',
   name                 varchar(64) comment '名称',
   level                int(1) comment '分类级别：0->1级；1->2级',
   product_count        int comment '商品数量',
   product_unit         varchar(64) comment '商品单位',
   nav_status           int(1) comment '是否显示在导航栏：0->不显示；1->显示',
   show_status          int(1) comment '显示状态：0->不显示；1->显示',
   sort                 int comment '排序',
   icon                 varchar(255) comment '图标',
   keywords             varchar(255) comment '关键字',
   description          text comment '描述',
   primary key (id)
);

-- 商品品牌表
DROP TABLE IF EXISTS `pms_brand`;
create table pms_brand
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '名称',
   first_letter         varchar(8) comment '首字母',
   sort                 int comment '排序',
   factory_status       int(1) comment '是否为品牌制造商：0->不是；1->是',
   show_status          int(1) comment '是否显示',
   product_count        int comment '产品数量',
   product_comment_count int comment '产品评论数量',
   logo                 varchar(255) comment '品牌logo',
   big_pic              varchar(255) comment '专区大图',
   brand_story          text comment '品牌故事',
   primary key (id)
);

-- 商品属性分类表
DROP TABLE IF EXISTS `pms_product_attribute_category`;
create table pms_product_attribute_category
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '名称',
   attribute_count      int comment '属性数量',
   param_count          int comment '参数数量',
   primary key (id)
);

-- 商品属性表
DROP TABLE IF EXISTS `pms_product_attribute`;
create table pms_product_attribute
(
   id                   bigint not null auto_increment,
   product_attribute_category_id bigint comment '商品属性分类id',
   name                 varchar(64) comment '名称',
   select_type          int(1) comment '属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；',
   input_type           int(1) comment '属性录入方式：0->手工录入；1->从列表中选取',
   input_list           varchar(255) comment '可选值列表，以逗号隔开',
   sort                 int comment '排序字段：最高的可以单独上传图片',
   filter_type          int(1) comment '分类筛选样式：1->普通；1->颜色',
   search_type          int(1) comment '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
   related_status       int(1) comment '相同属性产品是否关联；0->不关联；1->关联',
   hand_add_status      int(1) comment '是否支持手动新增；0->不支持；1->支持',
   type                 int(1) comment '属性的类型；0->规格；1->参数',
   primary key (id)
);


