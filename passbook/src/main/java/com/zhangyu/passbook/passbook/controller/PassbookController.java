//zhangyu de code
package com.zhangyu.passbook.passbook.controller;

import com.zhangyu.passbook.passbook.log.LogConstants;
import com.zhangyu.passbook.passbook.log.LogGenerator;
import com.zhangyu.passbook.passbook.service.IFeedbackService;
import com.zhangyu.passbook.passbook.service.IGainPassTemplateService;
import com.zhangyu.passbook.passbook.service.IInventoryService;
import com.zhangyu.passbook.passbook.service.IUserPassService;
import com.zhangyu.passbook.passbook.vo.Feedback;
import com.zhangyu.passbook.passbook.vo.GainPassTemplateRequest;
import com.zhangyu.passbook.passbook.vo.Pass;
import com.zhangyu.passbook.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/passbook")
public class PassbookController {
    //用户优惠券服务
    private final IUserPassService userPassService;
    //优惠券库存服务
    private final IInventoryService inventoryService;
    //领取优惠券服务
    private final IGainPassTemplateService gainPassTemplateService;
    //反馈服务
    private final IFeedbackService feedbackService;

    private final HttpServletRequest httpServletRequest;
    @Autowired
    public PassbookController(IUserPassService userPassService, IInventoryService inventoryService, IGainPassTemplateService gainPassTemplateService, IFeedbackService feedbackService, HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.inventoryService = inventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 获取用户个人的优惠券信息
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception{
        LogGenerator.genLog(
              httpServletRequest,
              userId, LogConstants.ActionName.USER_PASS_INFO,null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 获取用户使用了的优惠券信息
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/useruserdpassinfo")
    Response userUserdPassInfo(Long userId ) throws Exception{
        LogGenerator.genLog(
                httpServletRequest,userId,
                LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 用户使用优惠券
     * @param pass
     * @return
     */
    @ResponseBody
    @PostMapping("/userusepass")
    Response userUsePass(Pass pass){
        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                pass
        );
        return userPassService.userUsePass(pass);
    }
    /**
     * <h2>获取库存信息</h2>
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );
        return inventoryService.getInventoryInfo(userId);
    }

    /**
     * <h2>用户领取优惠券</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request)
            throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                request.getUserId(),
                LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * <h2>用户创建评论</h2>
     * @param feedback {@link Feedback}
     * @return {@link Response}
     * */
    @ResponseBody
    @PostMapping("/createfeedback")
    Response createFeedback(@RequestBody Feedback feedback) {

        LogGenerator.genLog(
                httpServletRequest,
                feedback.getUserId(),
                LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
        return feedbackService.createFeedback(feedback);
    }

    /**
     * <h2>用户获取评论信息</h2>
     * @param userId 用户 id
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/getfeedback")
    Response getFeedback(Long userId) {

        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.GET_FEEDBACK,
                null
        );
        return feedbackService.getFeedback(userId);
    }

    /**
     * <h2>异常演示接口</h2>
     * @return {@link Response}
     * */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception {
        throw new Exception("Welcome To IMOOC");
    }
}
