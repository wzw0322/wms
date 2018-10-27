package com.cxy.instore.dao;

import com.cxy.instore.entity.InstoreExtraInfo;
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

}
