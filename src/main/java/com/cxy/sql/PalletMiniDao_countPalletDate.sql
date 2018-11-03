select pallet_material as palletMaterial,pallet_model as palletModel,pallet_type as palletType,
	sum(case when pallet_status=0 then 1 else 0 end) as 'freeNum',
	sum(case when pallet_status=1 then 1 else 0 end) as 'useNum',
	sum(case when pallet_status=2 then 1 else 0 end) as 'maintainNum',
	sum(case when pallet_status=3 then 1 else 0 end) as 'lostNum'
from wms_pallet
where isdel=0 and create_date>=:startDay and create_date<=:endDay GROUP BY pallet_material,pallet_model,pallet_type