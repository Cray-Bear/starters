package com.fty1.center.auth.controller;

import com.fty1.center.auth.result.sign.SignInResult;
import com.fty1.center.auth.result.sign.SignOutResult;
import com.fty1.center.auth.result.sign.SignUpResult;
import com.fty1.common.core.signal.OutSignal;
import com.fty1.common.core.signal.SignalBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class SignController {

    @RequestMapping("/in")
    public OutSignal<SignInResult> signIn() {
        return SignalBuilder.success();
    }

    @RequestMapping("/up")
    public OutSignal<SignUpResult> signUp() {
        return SignalBuilder.success();
    }

    @RequestMapping("/out")
    public OutSignal<SignOutResult> signOut() {
        return SignalBuilder.success();
    }

}
