package cn.iocoder.yudao.module.bbs.service.mi;


import cn.iocoder.yudao.module.bbs.controller.app.mi.vo.MiSportVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aprilz
 * @since 2022-05-25
 */
public interface MIService {

    String updateMi(MiSportVo mi);

    String getCode(Integer type);
}
