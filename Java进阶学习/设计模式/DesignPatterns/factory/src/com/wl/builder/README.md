# Builder 生成器模式
生成器是一种创建型设计模式，使你能够分步骤创建复杂对象，该模式可以允许你使用相同的代码来实现不同对象的创建。
## 生成器模式的结构
- 生成器（Builder）接口声明在所有类型生成器中通用的产品构造步骤。
- 具体生成器（Concrete Builder）提供构造过程的不同实现。具体的构造器也可以构造不遵循通用接口的产品。
- 最终生成的对象由不同生成器构造的产品无需属于同一类层次结构或接口.
## 生成器适用的场景
- 使用生成器可以避免“重叠构造函数”的出现
- 当你希望使用代码创建不同形式的产品时，可以使用生成器模式。
- 使用生成器构造组合树或其它复杂对象。
## 实现方法
1. 清晰地定义通用的步骤，确保他们可以制造所有形式的产品。否则你讲无法进一步实施该模式。
2. 在基本生成器接口中声明这些步骤。
3. 为每个形式的产品创建具体的生成器类，并实现其构造步骤。
    不要忘记实现获取构造结果对象的方法。你不能在生成器接口中声明该方法，因为不同的生成器构造的产品可能没有公共接口，因此
   你就不知道该方法返回的对象类型。但是，如果所有产品都位于单一层次中，你就可以安全地在基本接口中添加获取生成对象的方法。
4. 考虑创建主管类。它可以使用同一生成器对象来封装多种构造产品的方式。
5. 客户端代码同时创建生成器和主管对象。构造开始前，客户端必须将生成器对象传递给主管对象。通常情况下，客户端只需调用主管类构造函数一次即可。 
主管类使用生成器对象完成后续所有制造任务。还有另一种方式，那就是客户端可以将生成器对象传递个主管类的制造方法。
6. 只有在所有产品都遵循相同接口的情况下，构造结果可以直接通过主管类获取。否则，客户端应当通过生成器获取构造结果。
## 生成器模式的优缺点
- 优点 
  - 你可以分步创建对象，暂缓创建步骤或递归运行创建步骤。
  - 生成不同形式的产品时，你可以复用相同的制造代码。
  - 单一职责原则。你可以将复杂构造代码从产品的业务逻辑中分离出来。
- 缺点
    - 由于该模式需要新增多个类，因此代码整体复杂程度会有所增加。