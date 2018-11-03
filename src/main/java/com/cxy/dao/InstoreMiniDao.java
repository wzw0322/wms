package com.cxy.dao;

import com.cxy.instore.entity.InstoreExtraInfo;
import com.cxy.instore.entity.WmsCheckCardEntity;
import com.cxy.instore.entity.WmsInstoreCardEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

/**
 * 功能描述:入库管理dao <br>
 *
 * @Author: wzw
 * @Date: 2018/10/27 14:05
 */
@MiniDao
public interface InstoreMiniDao {

    /**
     * 功能描述: 从订单表中查询未添加到入款单中的数据<br>
     * @Author: wzw
     * @Date: 2018/10/27 21:08
     * @Param order_code 定单编号
     */
    @Arguments("order_code")
    @ResultType(InstoreExtraInfo.class)
    InstoreExtraInfo getExtraInfoFromOrder(String order_code);

    /**
     * 功能描述: 根据入库单号修改单据状态<br>
     * @Author: wzw
     * @Date: 2018/10/27 21:17
     * @Param instoreCode 入库单号
     * @param status 修改后的状态
     * @return
     */
    @Arguments({"instoreCode","status"})
    @Sql("update wms_instore_card set instore_status=:status where instore_code=:instoreCode")
    Integer updateInstoreCardStatus(String instoreCode, int status);

    /**
     * 功能描述: 根据入库单号查询入库单<br>
     * @Author: wzw
     * @Date: 2018/10/27 21:18
     * @Param instore_code 入库单号
     * @return 
     */
    @Arguments("instore_code")
    @ResultType(WmsInstoreCardEntity.class)
    @Sql("select * from wms_instore_card where instore_code=:instore_code")
    WmsInstoreCardEntity getInstoreModelByInstoreCode(String instore_code);

    /**
     * 功能描述: 根据质检单号查询质检单 <br>
     * @Author: wzw
     * @Date: 2018/10/29 22:03
     * @Param qc_code 质检单号
     * @return
     */
    @Arguments("qc_code")
    @ResultType(WmsCheckCardEntity.class)
    @Sql("select * from wms_check_card where qc_code=:qc_code")
    WmsCheckCardEntity getCheckModelByCheckCode(String qc_code);

    /**
     * 功能描述: 根据ID修改收货单状态<br>
     * @Author: wzw
     * @Date: 2018/10/30 18:15
     * @return
     */
    @Arguments({"id","status"})
    @Sql("update wms_receive_card set sh_status=:status where id=:id")
    Integer updateReceiveCardStatus(String id, int status);

    /**
     * 功能描述: 收货单上架<br>
     * @Author: wzw
     * @Date: 2018/10/30 18:23
     * @Param
     */
    @Arguments({"id","status","positionId","on_shelf_man"})
    @Sql("update wms_receive_card set sh_status=:status,on_shelf_man=:on_shelf_man,position_id=:positionId,on_shelf_time=now() where id=:id")
    Integer onShelfReceiveCard(String id, int status, String positionId, String on_shelf_man);

}
