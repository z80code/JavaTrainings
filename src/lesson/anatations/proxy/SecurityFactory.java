package lesson.anatations.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by igor on 18.06.2015.
 */
public class SecurityFactory {

    public static IBankOperations createSecurityObj(BankOperations target) {
        Object ob = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new SecurityInvocationHandler(target) );


        return (IBankOperations) ob;
    }

    private static class SecurityInvocationHandler implements InvocationHandler {

        private Object targetObject = null;

        public SecurityInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            SecureLogic logic = new SecureLogic();
            Method realMethod = targetObject.getClass().getMethod(method.getName(),(Class[])method.getGenericParameterTypes());
            MethodAnnotation annotation = realMethod.getAnnotation(MethodAnnotation.class);
            if(annotation!=null) {
                logic.onInvoke(annotation.securityLevel(), realMethod,args);
                try {
                    System.out.println("proxy in");
                    return method.invoke(targetObject,args);
                } catch (InvocationTargetException e) {
                    System.out.println(annotation.securityLevel());
                    throw e.getCause();
                }
            } else {
                // ���� ��������� ���������� ��������� ����� ������� null
                return null;
            }

        }
    }
}
