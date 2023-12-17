package me.zhangjin.web.soa;


import me.zhangjin.types.Result;
import me.zhangjin.domain.command.linea.SubmitOrderCommand;
import me.zhangjin.types.dto.SubmitOrderDTO;
import me.zhangjin.types.soa.SubmitOrderRequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import me.zhangjin.application.OrderApp;

// 接口层

// 接口出参：统一返回 Result
// 异常处理：应该捕捉所有异常，避免异常信息的泄漏，可以通过 AOP 统一处理，避免代码里有大量重复代码

@Component
public class OrderService {

    @Autowired
    private OrderApp orderApp;

    public Result<Boolean> submitOrder(SubmitOrderRequestType submitOrderRequestType) {

        SubmitOrderCommand submitOrderCommand = new SubmitOrderCommand();

        SubmitOrderDTO res = orderApp.submitOrder(submitOrderCommand);

        if (res.getSuccess()) {
            return Result.success();
        } else {
            return Result.fail();
        }

    }


}
