package cn.iocoder.yudao.module.bbs.controller.app.jd.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("口令解析 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppJDJComExchangeRespVO {
    @ApiModelProperty(value = "活动图片地址")
    private String img;
    @ApiModelProperty(value = "活动标题")
    private String title;
    @ApiModelProperty(value = "分享人头像")
    private String headImg;
    @ApiModelProperty(value = "分享人昵称")
    private String userName;
    @ApiModelProperty(value = "活动地址")
    private String jumpUrl;
}
