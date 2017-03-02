package com.bidvct.vntools;

import static com.bidvct.vntools.docso.readNum;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;
import java.util.ArrayList;


public final class vntoolsImpl extends WeakBase
   implements com.bidvct.vntools.Xvntools,
              com.sun.star.lang.XServiceInfo,
              com.sun.star.lang.XLocalizable
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = vntoolsImpl.class.getName();
    private static final String[] m_serviceNames = {
        "com.bidvct.vntools.vntools" };

    private com.sun.star.lang.Locale m_locale = new com.sun.star.lang.Locale();

    public vntoolsImpl( XComponentContext context )
    {
        m_xContext = context;
    }

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(vntoolsImpl.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.bidvct.vntools.Xvntools:
    public String VND(String docso)
    {
        // TODO: Exchange the default return implementation for "VND" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
         ArrayList<String> kq = readNum(docso);
         String result = new String();
        for (int i = 0; i < kq.size(); i++) {
          result +=  kq.get(i)+ " ";
        }
        return result;
    }

    public String USD(String so)
    {
        // TODO: Exchange the default return implementation for "USD" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new String();
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // com.sun.star.lang.XLocalizable:
    public void setLocale(com.sun.star.lang.Locale eLocale)
    {
        m_locale = eLocale;
    }

    public com.sun.star.lang.Locale getLocale()
    {
        return m_locale;
    }

}
