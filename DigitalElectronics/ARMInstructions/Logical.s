DAT    DCD     0xEEEE3044, 0xDDDD20F2,0xFFFFC4F8
       LDR     R0, =0x200 ; base address
       LDR     R1, [R0], #4 ; R1 = P

       LDR     R2, [R0], #4 ; R2 = Q
       LDR     R3, [R0] ; R3 = R

       MOV     R11, R2, LSR #1
       EOR     R7, R11, R3, LSR #5 ; R7 = Q xor R
       ORR     R8, R7, R1, LSR #9 ; R8 = (Q xor R) or P
       AND     R10, R8, #0x3E ; Final result in R10