valueA DCD     627
valueB DCD     345
addrC  DCD     0xAAAAAAAA ; 0xAAAAAAAA at mem[addrC] will be replaced by function result
       ;       set up r7,r8,r11,sp to known value (should be unchanged after the function call).
       MOV     r7,#0x00055000 ; r7 = caller r7 value
       MOV     r8,#0x00000AA0 ; r8 = caller r8 value
       MOV     r11,#0xFF000000 ; Set caller frame & stack pointers to known values
       ADD     r11,r11,#16 ; r11 = 0xFF000010 (VisUAL does not support the name fp)
       ADD     sp,sp,#44 ; sp = 0xFF00002c
       ;       push parameters onto the stack
       ADR     r0,valueA ; r0 = address of valueA
       LDR     r1,[r0] ; r1 = valueA
       STR     r1,[sp,#-4]! ; push valueA onto the stack
       ;<<     push valueB and addrC onto the stack >>
       ADR     r0,valueB ; r0 = address of valueB
       LDR     r1,[r0] ; r1 = valueA
       STR     r1,[sp,#-4]! ; push valueA onto the stack
       ;<<     push addrC onto the stack >>
       ADR     r0,addrC ; r0 = addrC
       STR     r0,[sp,#-4]! ; push valueA onto the stack
       ;<<     call function >>
       BL      calc

       ;       load function result into r0 from mem[AddrC] >>
       ADR     r1, addrC
       LDR     r0, [r1]

       ;<<     restore stack pointer to its value prior to the pushing of the function parameters >>
       ADD     sp,sp,#28 ; sp = 0xFF00002c
       END     ; END OF PROGRAM

       ;       FUNCTION calc
       ;       parameters: valueA, valueB, addrC
       ;       modifies register r7 & r8
       ;       stores result at mem[addrC]
calc   STR     lr,[sp,#-4]! ; push link register (r14) onto the stack
       ;<<     push registers modified by function onto the stack >>
       STR     r7,[sp,#-4]!
       STR     r8,[sp,#-4]!
       ;<<     push the frame pointer onto the stack >> frame point is r11
       STR     r11,[sp,#-4]!
       MOV     r11,sp ; set the constant frame pointer (r11) for this function call
       SUB     sp,sp,#8 ; create a 2-word stack frame for intermediate results
       ;<<     CAN NOT USE ANY REGISTERS EXCEPT r7,r8 (frame pointer must be used to access values on stack) >>
       ;<<     calculate & store the result at mem[addrC] >>
       LDR     r7, [r11, #24] ;load a into r7
       LDR     r8, [r11, #20] ;load b into r8
       ORR     r7, r7, r8;(A or B)
       ADD     r8, r8, r8, LSL #3 ; 9*B
       ADD     r7, r7, r8 ;[9*B + (A or B)]
       ;27*A   - [9*B + (A or B)]
       LDR     r8, [r11, #24] ;load a into r8
       ADD     r8, r8, r8, LSL #1 ; 9*A
       ADD     r8, r8, r8, LSL #1 ; 9*A
       ADD     r8, r8, r8, LSL #1 ; 9*A

       SUB     r8, r8, r7 ;27*A - [9*B + (A or B)]

       ADR     r7, addrC ; r7 = addressC
       STR     r8,[r7]! ; push valueA onto the stack

       ADD     sp,sp,#8 ; delete the 2-word stack frame
       ldr     r7, [sp, #8]
       ldr     r8, [sp, #4] ; restore registers by the function
       ldr     pc, [sp, #12]

       ;<<     restore registers used by the function from the stack >>
       ;<<     return from the function back to the caller >>
       ;<<     (HINT: set the program counter to the "return address" stored on the stack ) >>