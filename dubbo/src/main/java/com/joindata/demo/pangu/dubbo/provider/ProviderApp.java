package com.joindata.demo.pangu.dubbo.provider;

import com.joindata.inf.boot.Bootstrap;
import com.joindata.inf.boot.annotation.JoindataApp;
import com.joindata.inf.common.support.disconf.EnableDisconf;
import com.joindata.inf.common.support.dubbo.EnableDubbo;

/**
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date 2018年2月27日 下午4:26:09
 */
@JoindataApp(id = "DEMO.PANGU")
@EnableDisconf
@EnableDubbo
public class ProviderApp
{
    static
    {
        // XXX 注意！注意！注意！
        //
        // 这段代码中写这两个参数写到这里是为了编写 Demo 方便，如果在开发中，应该这么做：
        // - 在 IDE 的启动工具中的 VM Arguments 中填写“ -Ddisconf.env=LOCAL -Ddisconf.conf_server_host=10.10.110.50 ”
        // 同样的，在 Linux 环境中（比如开发环境），应该这么做：
        // - 在 /var/config/_DISCONF_OPTS 文件中填写：“ -Ddisconf.env=DEV -Ddisconf.conf_server_host=10.10.110.50 ”
        // - 如果没有这个文件，也要创建这个文件，并填写上述内容
        //
        // XXX 注意结束
        System.setProperty("disconf.env", "LOCAL");
        System.setProperty("disconf.conf_server_host", "10.10.110.50");

        // 自 pangu-1.2.0 开始，开发阶段无需关心版本号，永远是 1.0.0
        // 这个参数是为了确保程序运行在指定版本下（因为在 Disconf 中这些 demo 是用版本号区分的，所以必须要有）
        // 在开发环境不要设置这个启动参数，用 1.0.0 就行，打包插件会将 pom 文件中的 version 取出作为应用版本自动设置到发布件中的程序的启动参数中
        System.setProperty("app.version", "Dubbo");
    }

    // XXX 说明
    // - 要是用 Dubbo，必须在 Disconf 中必须要有个 dubbo.properties 文件，请登录 Disconf 在 DEMO.PANGU > Dubbo 中查看
    public static void main(String[] args) throws InterruptedException
    {
        Bootstrap.boot();

        // 如果启动后程序自动正常退出，可加上这一句
        Thread.currentThread().join();
    }
}