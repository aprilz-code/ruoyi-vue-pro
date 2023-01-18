package cn.iocoder.yudao.module.bbs.service.jd;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.framework.common.exception.ServerException;
import cn.iocoder.yudao.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeRespVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJCommandReqVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Classname JdServiceImpl
 * @Description JdServiceImpl
 * @Date 2023/1/18 12:15
 * @Created by white
 */
@Service
public class JdServiceImpl implements JdService {

    private static final String NOLAN_API = "https://api.nolanstore.top";

    @Override
    public AppJDJComExchangeRespVO jComExchange(AppJDJComExchangeReqVO reqVO) {
        HashMap<String, String> param = MapUtil.newHashMap(1);
        param.put("code", reqVO.getCode());
        String result = HttpUtil.post(NOLAN_API + "/JComExchange", JSONUtil.toJsonStr(param));
        JSONObject entries = JSON.parseObject(result);
        if (Objects.isNull(entries) || !"0".equals(entries.getString("code"))) {
            throw new ServerException(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR);
        }
        return JSON.parseObject(entries.getString("data"), AppJDJComExchangeRespVO.class);

    }

    @Override
    public String jCommand(AppJDJCommandReqVO reqVO) {
        String result = HttpUtil.post(NOLAN_API + "/JCommand", JSONUtil.toJsonStr(reqVO));
        JSONObject entries = JSON.parseObject(result);
        if (Objects.isNull(entries) || !"0".equals(entries.getString("code"))) {
            throw new ServerException(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR);
        }
        return entries.getString("data");
    }
}
