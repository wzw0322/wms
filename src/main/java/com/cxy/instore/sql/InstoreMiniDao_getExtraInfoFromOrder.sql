select o.customer_code as customerCode,
  d.goods_code as goodsCode,
  d.goods_type as goodsType,
  d.goods_volume as volume
from oms_order_info o left join oms_order_detail d on o.id=d.fk_order_id
where o.order_code=:order_code