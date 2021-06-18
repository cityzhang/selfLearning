-- 商品表
DROP TABLE IF EXISTS `pms_product`;
create table pms_product
(
   id                   bigint not null auto_increment,
   brand_id             bigint comment '品牌id',
   product_category_id  bigint comment '品牌分类id',
   feight_template_id   bigint comment '运费模版id',
   product_attribute_category_id bigint comment '品牌属性分类id',
   name                 varchar(64) not null comment '商品名称',
   pic                  varchar(255) comment '图片',
   product_sn           varchar(64) not null comment '货号',
   delete_status        int(1) comment '删除状态：0->未删除；1->已删除',
   publish_status       int(1) comment '上架状态：0->下架；1->上架',
   new_status           int(1) comment '新品状态:0->不是新品；1->新品',
   recommand_status     int(1) comment '推荐状态；0->不推荐；1->推荐',
   verify_status        int(1) comment '审核状态：0->未审核；1->审核通过',
   sort                 int comment '排序',
   sale                 int comment '销量',
   price                decimal(10,2) comment '价格',
   promotion_price      decimal(10,2) comment '促销价格',
   gift_growth          int default 0 comment '赠送的成长值',
   gift_point           int default 0 comment '赠送的积分',
   use_point_limit      int comment '限制使用的积分数',
   sub_title            varchar(255) comment '副标题',
   description          text comment '商品描述',
   original_price       decimal(10,2) comment '市场价',
   stock                int comment '库存',
   low_stock            int comment '库存预警值',
   unit                 varchar(16) comment '单位',
   weight               decimal(10,2) comment '商品重量，默认为克',
   preview_status       int(1) comment '是否为预告商品：0->不是；1->是',
   service_ids          varchar(64) comment '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
   keywords             varchar(255) comment '关键字',
   note                 varchar(255) comment '备注',
   album_pics           varchar(255) comment '画册图片，连产品图片限制为5张，以逗号分割',
   detail_title         varchar(255) comment '详情标题',
   detail_desc          text comment '详情描述',
   detail_html          text comment '产品详情网页内容',
   detail_mobile_html   text comment '移动端网页详情',
   promotion_start_time datetime comment '促销开始时间',
   promotion_end_time   datetime comment '促销结束时间',
   promotion_per_limit  int comment '活动限购数量',
   promotion_type       int(1) comment '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
   product_category_name varchar(255) comment '产品分类名称',
   brand_name           varchar(255) comment '品牌名称',
   primary key (id)
);

-- 商品SKU表
DROP TABLE IF EXISTS `pms_sku_stock`;
create table pms_sku_stock
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   sku_code             varchar(64) not null comment 'sku编码',
   price                decimal(10,2) comment '价格',
   stock                int default 0 comment '库存',
   low_stock            int comment '预警库存',
   sp1                  varchar(64) comment '规格属性1',
   sp2                  varchar(64) comment '规格属性2',
   sp3                  varchar(64) comment '规格属性3',
   pic                  varchar(255) comment '展示图片',
   sale                 int comment '销量',
   promotion_price      decimal(10,2) comment '单品促销价格',
   lock_stock           int default 0 comment '锁定库存',
   primary key (id)
);

-- 商品阶梯价格表
DROP TABLE IF EXISTS `pms_product_ladder`;
create table pms_product_ladder
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   count                int comment '满足的商品数量',
   discount             decimal(10,2) comment '折扣',
   price                decimal(10,2) comment '折后价格',
   primary key (id)
);

-- 商品满减表
DROP TABLE IF EXISTS `pms_product_full_reduction`;
create table pms_product_full_reduction
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   full_price           decimal(10,2) comment '商品满足金额',
   reduce_price         decimal(10,2) comment '商品减少金额',
   primary key (id)
);

-- 商品会员价格表
DROP TABLE IF EXISTS `pms_member_price`;
create table pms_member_price
(
   id                   bigint not null auto_increment,
   product_id           bigint comment '商品id',
   member_level_id      bigint comment '会员等级id',
   member_price         decimal(10,2) comment '会员价格',
   member_level_name    varchar(100) comment '会员等级名称',
   primary key (id)
);
