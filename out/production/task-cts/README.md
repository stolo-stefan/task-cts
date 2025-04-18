# Kebap nu cu de toate... ci doar cu ce trebuie... SRL

After hearing about the resounding success and profit of vending machines, the **Contralipielescu family** decided to embrace the entrepreneurial spirit themselves.  
They decided to forever revolutionize the market and invent... **kebab without pita**.

So, they got right to work and launched the new brand:

> **“Kebap nu cu de toate... ci doar cu ce trebuie... SRL”**

Being strong believers in the concept of personalization, they want every customer to be able to create a kebab that truly speaks to their soul.

To succeed in this, the Contralipielescu family has hired your company to create an app that allows customers to **build their kebab step by step**.

---

## "No onions, please...":

### General Rules

- A kebab **must include at least** one **source of protein** and one **source of carbohydrates**
- Customers can add **only one** type from each ingredient category
- **Exception:** Sauces – up to **three** types allowed
- Ingredients can be freely chosen **as long as the rules above are respected**

### Ingredient Categories

- **Proteins:** chicken, lamb, falafel
- **Carbohydrates:** potatoes, rice
- **Pickles:** cucumbers, onions
- **Sauces:** tahini, samurai, tzatziki, ketchup, and others...
- **Wraps:** salad, pita *(you'll disappoint the Contralipielescu family with this one)*
- **Fibers:** cabbage, tomatoes, carrots
- **Healthy:** spinach, radish

### Sauce Rules

- Sauces **cannot be added before** the protein source
- Sauces that can **ferment quickly** (e.g., samurai, tzatziki) will include **shelf-life info** (e.g., 8h, 12h)
- Other sauces **do not require** shelf-life info
- Kebab objects should have the ability to **inform the consumer of the shelf life** (if applicable) of each sauce

---

##  CLI Functionality

### Implement a minimalist Command Line Interface (CLI) for:

#### Kebabs
- Create
- Delete
- List
- Filter by a chosen criterion

#### Sauces
- Create
- Delete

#### Persistence
- Serialization of sauces to a **text file**
- Deserialization of sauces from a **text file**

---

## Development Guidelines

- Apply **SOLID principles**
- Correctly identify and apply **appropriate design solutions**
- Other code units (besides kebab and sauce) should use the **minimum necessary attributes, methods, etc.**

---

## Code Smells to Watch Out For

- **Bloaters**
- **Complicated if/switches**
- **Unused fields**
- **Divergent change / Shotgun surgery**
- **Dispensable code**
- **Feature envy**
- **Inappropriate intimacy**
- **Message chain / Middle man**
