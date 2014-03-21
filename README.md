Cascalog Sandbox
================

Playing with NHS dataset. 

The dataset head looks like this:

```
SHA,PCT,PRACTICE,BNF CODE,BNF NAME                                    ,ITEMS  ,NIC        ,ACT COST   ,QUANTITY,PERIOD,
Q30,5D7,Y00925,0202020L0AABDBD,Furosemide_Tab 40mg                     ,0000001,00000001.03,00000001.06,0000035,201311,
Q30,5D7,Y00925,0208020V0AAADAD,Warfarin Sod_Tab 5mg                    ,0000001,00000000.54,00000000.61,0000016,201311,
Q30,5D7,Y00925,0403040X0AAAAAA,Mirtazapine_Tab 30mg                    ,0000001,00000001.97,00000001.83,0000028,201311,
Q30,5D7,Y00925,0407010H0AAAMAM,Paracet_Tab 500mg                       ,0000003,00000009.24,00000008.76,0000336,201311,
Q30,5D7,Y00925,0407010P0AAABAB,Nefopam HCl_Tab 30mg                    ,0000001,00000003.53,00000003.37,0000030,201311,
Q30,5D7,Y00925,0407020C0AAAEAE,Codeine Phos_Tab 30mg                   ,0000002,00000004.20,00000003.90,0000084,201311,
Q30,5D7,Y00925,0407020Q0BCAGCN,Oramorph_Oral Soln 10mg/5ml             ,0000001,00000005.67,00000005.24,0000300,201311,
Q30,5D7,Y00925,0407020Q0BKAAEF,Zomorph_Cap 10mg                        ,0000001,00000003.47,00000003.21,0000060,201311,
Q30,5D7,Y00925,0408010G0AAAAAA,Gabapentin_Cap 100mg                    ,0000001,00000001.68,00000001.66,0000028,201311,
```

## Usage

1. Need some data, I'm using NHS's GP Practice Prescribing Presentation-level Data. You can download from here: http://www.hscic.gov.uk/searchcatalogue?productid=14285&infotype=0%2fOpen+data&sort=Most+recent&size=10&page=1#top
(GP Practice Prescribing Presentation-level Data - November 2013: Practice prescribing data)

2. Then you can run it with Leiningen:

`lein run /tmp/T201311PDPI+BNFT.CSV /tmp/output`

Brave and power users:

`hadoop jar ./target/cascalogsandbox.jar /tmp/T201311PDPI+BNFT.CSV /tmp/output`

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
