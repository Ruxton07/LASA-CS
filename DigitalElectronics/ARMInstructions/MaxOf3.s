DAT    DCD     0x5,0x7,0x3
       LDR     R0, =0x200 ; base address
       LDR     R1, [R0], #4 ; R1 = P

       LDR     R2, [R0], #4 ; R2 = Q
       LDR     R3, [R0] ; R3 = R

       CMP     R2, R1 ; Compare Q to P
       MOVGT   R1, R2 ; If Q > P, R1 = Q

       CMP     R3, R1 ; Compare R to current max
       MOVGT   R1, R3 ; If R > max, R1 = R