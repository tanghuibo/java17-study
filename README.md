# Java 17 学习

## maven配置 java 17

pom.xml 进行如下配置，若不生效请检查属性是否被 maven 的 setting.xml 覆盖

```xml
 <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <maven.compiler.compilerVersion>17</maven.compiler.compilerVersion>
</properties>
```