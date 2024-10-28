from scipy.stats import norm

# Given values
sigma = 7.5   # Standard deviation
delta = 2.5   # Effect size
alpha = 0.07  # Significance level

# Z-scores
z_alpha = norm.ppf(1 - alpha / 2)  # Z_alpha/2
z_beta_80 = norm.ppf(0.8)  # Z for 80% power
z_beta_70 = norm.ppf(0.7)  # Z for 70% power
z_beta_90 = norm.ppf(0.9)  # Z for 90% power

# Function to calculate sample size per group
def sample_size_per_group(z_alpha, z_beta, sigma, delta):
    return (2 * (z_alpha + z_beta)**2 * sigma**2) / delta**2

# Calculate sample sizes for different power levels
n_80 = sample_size_per_group(z_alpha, z_beta_80, sigma, delta)
n_70 = sample_size_per_group(z_alpha, z_beta_70, sigma, delta)
n_90 = sample_size_per_group(z_alpha, z_beta_90, sigma, delta)

# Total sample sizes (5 alloys, each with n replications)
total_n_80 = 5 * n_80
total_n_70 = 5 * n_70
total_n_90 = 5 * n_90

total_n_80, total_n_70, total_n_90
