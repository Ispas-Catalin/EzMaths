package com.example.ezmaths.Asigurari.AsigurariViata;

import com.example.ezmaths.R;

import static android.provider.Settings.System.getString;

public class AsigDataSource {



    public String[] getAnuitati (int variant)
    {

        return generateAnuitati(variant);

    }

    private String [] generateAnuitati(int variant)
    {
        if (variant == 1)
        {
            return new String[]{
                    "A.V.P.I. Imediate si limitate la N ani",
                    "A.V.P.F. Imediate si limitate la N ani",
                    "A.V.A.I. Imediate si limitate la N ani" ,
                    "A.V.A.F. Imediate si limitate la N ani"
            };
        }

        if (variant == 2 )
        {
            return new String[]{
                    "A.V.P.I. Nelimitate si amante cu N ani",
                    "A.V.P.F. Nelimitate si amante cu N ani",
                    "A.V.A.I. Nelimitate si amante cu N ani" ,
                    "A.V.A.F. Nelimitate si amante cu N ani"
            };
        }

        if (variant == 3)
         return new String[]{"A.V.P.I. Imediate si nelimitate",
                        "A.V.P.I. Imediate si limitate la N ani" ,
                        "A.V.P.I. Nelimitate si amanate cu N ani" ,

                        "A.V.P.F. Imediate si nelimitate"  ,
                        "A.V.P.F. Imediate si limitate la N ani" ,
                        "A.V.P.F. Nelimitate si amanate cu N ani"  ,

                        "A.V.A.I. Imediate si nelimitate"  ,
                        "A.V.A.I. Imediate si limitate la N ani" ,
                        "A.V.A.I. Nelimitate si amanate cu N ani"  ,

                        "A.V.A.F. Imediate si nelimitate" ,
                        "A.V.A.F. Imediate si limitate la N ani" ,
                        "A.V.A.F. Nelimitate si amanate cu N ani"  };

        if (variant == 4)
            return new String[]{
                    "Anuitati de deces",
                    "Anuitati de deces limitate la N ani",
                    "Anuitait de deces dublu limitate",
                    "Anuitati de deces amanate cu N ani"
            };

        return new String[]{};
    }
}
