1. 只涉及了属性为方法与类的依赖注入,没有涉及将注解标在类上
2. 注解的target注意不是@Target({ElementType.FIELD.METHOD,ElementType.FIELD})
而是@Target({ElementType.METHOD, ElementType.FIELD})
3. 类与实例:
    类是指的.class文件
    实例是指Object
4. 注意依赖注入的根本上还是需要用get/set,不显示的也只是因为插件的原因,在编译期
显示,因为哪怕是注解注入,也是判断注解和
因为属性是不被直接识别的,都是根据propertyDescriptor进行识别的,也就是说name是不被
识别的,只能通过属性描述器propertyDescriptors中的getName得知有一个name属性
5. propertyDescriptors
属性描述器,指一个类(.class)中的所有属性.主要分为
propertyTypeRef:    其他类的路径
readMethodRef:      读方法
writeMethodRef:     写方法
6. 具体的注解可以见annotation工程