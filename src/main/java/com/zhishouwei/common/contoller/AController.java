package com.zhishouwei.common.contoller;

import com.zhishouwei.common.model.entity.AEntity;
import com.zhishouwei.common.model.service.impl.AServerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("A")
public class AController extends BaseController<AEntity, AServerImpl> {
}
