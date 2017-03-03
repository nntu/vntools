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
        String result = new String();
        if(docso.isEmpty())
        {
            result = "Ô rỗng";
        
        } 
        else
        {
            ArrayList<String> kq = readNum(docso);
           
           for (int i = 0; i < kq.size(); i++) {
             result +=  kq.get(i)+ " ";
           }
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
        
        
        
        String result = new String();
        if(so.isEmpty())
        {
            result = "Ô rỗng";
        
        } 
        else
        {
            Float num = new Float( so ) ;
           int dollars = (int)Math.floor( num ) ;
           int cent = (int)Math.floor( ( num - dollars ) * 100.0f ) ;

           result = "" + EnglishNumberToWords.convert( dollars ) + " and "
              + EnglishNumberToWords.convert( cent ) + " cents" ;
        }
        return result;
    }

    // com.sun.star.lang.XServiceInfo:
    @Override
    public String getImplementationName() {
         return m_implementationName;
    }

    @Override
    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    @Override
    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // com.sun.star.lang.XLocalizable:
    @Override
    public void setLocale(com.sun.star.lang.Locale eLocale)
    {
        m_locale = eLocale;
    }

    @Override
    public com.sun.star.lang.Locale getLocale()
    {
        return m_locale;
    }

}
