import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import statsmodels.api as sm
import statsmodels.formula.api as smf
from statsmodels.stats.multicomp import pairwise_tukeyhsd

# Load the dataset

data = pd.read_excel(r'STAT406\HW9\Fibers.xlsx')

# Inspect the dataset to understand its structure
print(data.head())

# Compute mean strength for each Polymer and Coating combination
mean_strength = data.groupby(['polymer', 'coating'])['strength'].mean().reset_index()
print(mean_strength)

# Plot the interaction plot using Seaborn
plt.figure(figsize=(8, 6))
sns.pointplot(x='polymer', y='strength', hue='coating', data=data, dodge=True, markers=["o", "s"], capsize=0.1)
plt.title('Interaction Plot: Polymer vs Coating on Strength')
plt.show()


# Fit a mixed effects model
model = smf.mixedlm("strength ~ polymer * coating", data, groups=data["lot"])
result = model.fit(reml=True)

# Display the summary
print(result.summary())

# Report P-values for interaction and main effects
p_interaction = result.pvalues["polymer:coating"]
p_polymer = result.pvalues["polymer"]
p_coating = result.pvalues["coating"]

# Decision-making based on p-values (95% confidence)
print(f"P-value for Polymer × Coating Interaction: {p_interaction}")
print(f"P-value for Polymer Effect: {p_polymer}")
print(f"P-value for Coating Effect: {p_coating}")

# Check if significant interaction or main effects exist
print("Interaction Effect (95%):", "Yes" if p_interaction < 0.05 else "No")
print("Polymer Effect (95%):", "Yes" if p_polymer < 0.05 else "No")
print("Coating Effect (95%):", "Yes" if p_coating < 0.05 else "No")

# Perform Tukey HSD post-hoc comparison for polymers
tukey_polymer = pairwise_tukeyhsd(data['strength'], data['polymer'], alpha=0.05)
print(tukey_polymer)

# Perform Tukey HSD post-hoc comparison for coatings
tukey_coating = pairwise_tukeyhsd(data['strength'], data['coating'], alpha=0.05)
print(tukey_coating)
# Optional: Visualization of the interaction plot using Seaborn
import seaborn as sns
import matplotlib.pyplot as plt

sns.pointplot(x='polymer', y='strength', hue='coating', data=data, dodge=True, markers=['o', 's'])
plt.title('Interaction Plot: Strength vs Polymer & Coating')
plt.show()