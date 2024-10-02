import pandas as pd

# Create data for beer preference study
data = {
    "Gender": ["Women"] * 130 + ["Men"] * 70,
    "Preferred_Light_Beer": ["Light Beer"] * 75 + ["Full Bodied Beer"] * (130 - 75) + ["Light Beer"] * 40 + ["Full Bodied Beer"] * (70 - 40),
}

# Create DataFrame
df = pd.DataFrame(data)

# Save the dataframe to an Excel file
df.to_excel("beer_preference_study.xlsx", index=False)

