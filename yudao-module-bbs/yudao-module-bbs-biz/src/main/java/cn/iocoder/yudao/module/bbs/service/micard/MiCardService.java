package cn.iocoder.yudao.module.bbs.service.micard;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.bbs.controller.app.micard.vo.*;
import cn.iocoder.yudao.module.bbs.dal.dataobject.micard.MiCardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 米卡密 Service 接口
 *
 * @author 芋道源码
 */
public interface MiCardService {

    /**
     * 创建米卡密
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMiCard(@Valid AppMiCardCreateReqVO createReqVO);

    /**
     * 更新米卡密
     *
     * @param updateReqVO 更新信息
     */
    void updateMiCard(@Valid AppMiCardUpdateReqVO updateReqVO);

    /**
     * 删除米卡密
     *
     * @param id 编号
     */
    void deleteMiCard(Long id);

    /**
     * 获得米卡密
     *
     * @param id 编号
     * @return 米卡密
     */
    MiCardDO getMiCard(Long id);

    /**
     * 获得米卡密列表
     *
     * @param ids 编号
     * @return 米卡密列表
     */
    List<MiCardDO> getMiCardList(Collection<Long> ids);

    /**
     * 获得米卡密分页
     *
     * @param pageReqVO 分页查询
     * @return 米卡密分页
     */
    PageResult<MiCardDO> getMiCardPage(AppMiCardPageReqVO pageReqVO);

    /**
     * 获得米卡密列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 米卡密列表
     */
    List<MiCardDO> getMiCardList(AppMiCardExportReqVO exportReqVO);

}
