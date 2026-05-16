/**
 * maven 没有下载完成，或者下载中的时候网络异常了，会导致依赖报红色波浪线
 * 解决方案：
 *     找到对应仓库中的xxx.lastUpdated文件删除后重新加载项目
 *     通过命令del /s *.lastUpdated 来批量删除，要在maven的安装目录下
 *         windows：C:\apache-maven-x.x.x
 *         mac: ~/.m2/repository
*      然后再刷新项目的maven就行
 */
public class a36_mavenDepError {
}
