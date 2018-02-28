package com.joindata.demo.pangu.restful;

import com.joindata.inf.boot.Bootstrap;
import com.joindata.inf.boot.annotation.JoindataWebApp;
import com.joindata.inf.boot.annotation.NewRestStyle;
import com.joindata.inf.common.support.disconf.EnableDisconf;
import com.joindata.inf.common.support.swagger.EnableSwagger;
import com.joindata.inf.common.util.network.NetworkUtil;

/**
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date 2018年2月27日 下午4:27:20
 */
@JoindataWebApp(id = "DEMO.PANGU", staticDir = "/static")
@EnableSwagger(apiRoot = "/api", title = "RESTful HTTP 接口开发例子")
@EnableDisconf
@NewRestStyle
public class App
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
        System.setProperty("app.version", "RESTful");

        // 注意！在正式运行时请务必将该参数写到启动参数中：-dhttp.port=[端口号]
        // 当部署在 Linux 系统中时，该参数可以在 /var/config/[AppID]/APP_OPTS 中修改
        // 为了保证成功启动，使用随机端口
        System.setProperty("http.port", "" + NetworkUtil.nextUsableLocalPort(8080, 9000));
    }

    // XXX 说明
    // 本例并没有引入需要 Disconf 配置的组件，仅仅演示如何写好 REST 接口
    // 运行成功后，打开浏览器输入 http://localhost:8080/swagger-ui.html 可以打开测试页面
    public static void main(String[] args)
    {
        Bootstrap.boot();
    }
}