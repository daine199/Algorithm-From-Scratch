# Thunneycomb-Autotest
主页：
https://www.thunneycomb.com/wiki/learning_notes/springboot_testng/

2019-12-23 Update by Daine.H
1. 增加GitHub 流水线，今后每次提交代码时会完成测试
2. 升级fastjson 1.2.58 到1.2.62

2019-11-08 Update by Daine.H
通过本模板创建新项目：
1. mvn clean install
2. mvn archetype:create-from-project
3. cd target\generated-sources\archetype
4. mvn clean install
5. 跟进本地模板创建新项目  
mvn archetype:generate  \
 -DarchetypeCatalog=local \
 -DgroupId=com.thunneycomb \
-DartifactId=new-name \
-DarchetypeGroupId=com.thunneycomb \
-DarchetypeArtifactId= thunneycomb-autotest-base-archtype\
-DarchetypeVersion=0.0.1-SNAPSHOT \
-DinteractiveMode=false 

2019-11-08 Update by Daine.H
1. 单纯的应用TestNG或JUnit，都可以完成mvn clean package时的执行。在单元测试上，单元测试mock上TestNG没有特别额外的价值。建议项目内单元测试尽量还是使用自带的JUnit。
2. 如果要做简单接口测试，可以考虑采用mock工具包或mokito，目前springboot的mock工具包可以支持rest接口的mock，能更有效完成底层测试。
3. 但是在业务集成测试上，仍然需要更多的测试策略和测试编排。在这一点上，必须得使用surfire 插件，业务场景测试的工程其实不见得需要使用springboot，原有的sping4、5也能非常好的完成任务。  

测试方法：
- mvn clean package  
常规单元测试方法，可以把所有用例完成执行，更适用于单元，接口测试。
- mvn surefire:test  
将采用surefire插件直接识别testngxml完成测试suite的执行， 能有效编排场景。
- mvn clean -U test -Dtestng-xml-name=testng2.xml  
“-U”为强制更新所有的snapshot包，test为默认执行surfire的测试  
    1. test的含义是默认使用surfire完成测试testng-xml-name 
    2. -D 传入参数动态选择用例策略。


2019-07-25  
thunneycomb的自动化脚手架项目 初始化项目 By Daine.H
